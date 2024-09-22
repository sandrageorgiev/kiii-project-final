sudo k3d cluster create test-kiii -p "80:80@loadbalancer" -a 2
sudo bash -c "openssl rand -base64 756 > mongodb-keyfile"
sudo chmod 400 mongodb-keyfile
sudo kubectl create secret generic mongodb-keyfile -n airbnb --from-file=mongodb-keyfile
sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/cloud/deploy.yaml
sudo kubectl apply -f namespace.yaml
sudo kubectl apply -f mongo-secrets.yaml
sudo kubectl apply -f secrets.yaml
sudo kubectl apply -f app-config.yaml
sudo kubectl apply -f postgres-pv.yaml
sudo kubectl apply -f main-app.yaml
sudo kubectl apply -f frontend.yaml
sudo kubectl apply -f services.yaml