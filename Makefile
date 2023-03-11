build:
	docker build -f docker/Dockerfile . -t yakovmm/otus-msa-hw2:v1

push:
	docker push yakovmm/otus-msa-hw2:v1

docker-start:
	cd docker && docker-compose up -d

docker-stop:
	cd docker && docker-compose down

k8s-deploy:
	helm/deploy.sh

k8s-remove:
	helm/remove.sh

newman:
	newman run postman/collection.json