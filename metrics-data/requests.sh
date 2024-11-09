#!/bin/bash

words=("Wallmart" "Amazon" "Best Buy" "Home Depot" "Ebay")
endpoint="http://localhost:8080/purchases/"

savePurchase() {
    word=${words[$RANDOM % ${#words[@]}]}
    response=$(curl --location "$endpoint" \
        --header "Content-Type: application/json" \
        --data "{
            \"store\" : \"$word\"
        }" -s -o /dev/null -w "%{http_code}")
    echo "Call to $endpoint with store: $word, Status Code: $response"
}

end=$((SECONDS+600))

while [ $SECONDS -lt $end ]; do
    savePurchase
    sleep 1
done
