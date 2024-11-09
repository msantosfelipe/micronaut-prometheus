start-docker:
	cd metrics-data/ && docker compose up -d

stop-docker:
	cd metrics-data/ && docker compose stop

remove-docker:
	cd metrics-data/ && docker compose down

do-requests:
	cd metrics-data/ && chmod +x requests.sh && ./requests.sh