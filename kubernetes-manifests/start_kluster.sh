sudo k3d cluster create test-kiii -p "80:80@loadbalancer" -a 2

sudo chmod 400 mongodb-keyfile

sudo kubectl create secret generic mongodb-keyfile -n airbnb --from-file=mongodb-keyfile
kreiram secret vo mojot namespace

sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/cloud/deploy.yaml
za nginx ingress controller


sudo kubectl apply -f namespace.yaml
sudo kubectl apply -f mongo-secrets.yaml
sudo kubectl apply -f secrets.yaml
sudo kubectl apply -f app-config.yaml

sudo kubectl apply -f mongo-pv.yaml

sudo kubectl apply -f frontend.yaml

sudo kubectl apply -f services.yaml

sudo kubectl exec -it mongodb-0 -n airbnb  -- mongosh

rs.initiate({
  _id: "rs0",
  members: [
    { _id: 0, host: "mongodb-0.mongodb-service:27017", priority: 2 },
    { _id: 1, host: "mongodb-1.mongodb-service:27017", priority: 1 },
    { _id: 2, host: "mongodb-2.mongodb-service:27017", priority: 1 }
  ]
})

sudo kubectl apply -f main-app.yaml

sudo kubectl apply -f ingress.yaml
