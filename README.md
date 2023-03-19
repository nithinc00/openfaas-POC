#  Welcome to the OpenFaas-POC wiki!   

**For the windows setup please follow the below steps**
**(Use git Bash to run all the commands)**

##  Step 1 : Install Arkade
command: `curl -sSL https://get.arkade.dev/ | sh`

##  Step 2 : Install openfaas using arkade
command : `arkade install openfaas`

> Release "openfaas" does not exist. Installing it now.
> NAME: openfaas
> LAST DEPLOYED: Sun Mar 19 11:22:34 2023
> NAMESPACE: openfaas
> STATUS: deployed
> REVISION: 1
> TEST SUITE: None
> NOTES:
> To verify that openfaas has started, run:
> kubectl -n openfaas get deployments -l "release=openfaas, app=openfaas"

> To retrieve the admin password, run:
> echo $(kubectl -n openfaas get secret basic-auth -o jsonpath="{.data.basic-auth-password}" | base64 --decode)

> OpenFaaS has been installed.

> Get the faas-cli
> curl -SLsf https://cli.openfaas.com | sudo sh

> Forward the gateway to your machine
> kubectl rollout status -n openfaas deploy/gateway
> kubectl port-forward -n openfaas svc/gateway 8080:8080 &

> If basic auth is enabled, you can now log into your gateway:
> PASSWORD=$(kubectl get secret -n openfaas basic-auth -o jsonpath="{.data.basic-auth-password}" | base64 --decode; echo)
> echo -n $PASSWORD | faas-cli login --username admin --password-stdin

> faas-cli store deploy figlet
> faas-cli list

> For Raspberry Pi
> faas-cli store list \
>  --platform armhf

> faas-cli store deploy figlet \
>  --platform armhf

>  Find out more at:
>  https://github.com/openfaas/faas

> ≡ƒÉ│ arkade needs your support: https://github.com/sponsors/alexellis

## Step 3: Verify openfaas installation
command: `kubectl -n openfaas get deployments -l "release=openfaas, app=openfaas"`

![image](https://user-images.githubusercontent.com/65301458/226156562-cd39f49e-b777-435b-9526-fbe5b0f061ad.png)

## Step 4 : To retrieve the admin password, run:
command: `echo $(kubectl -n openfaas get secret basic-auth -o jsonpath="{.data.basic-auth-password}" | base64 --decode)`

## Step 5 : Get the faas-cli
command: `curl -SLsf https://cli.openfaas.com | sh`

![image](https://user-images.githubusercontent.com/65301458/226156918-6d0c8a10-8cb7-45cc-a0a9-0900069dad07.png)


## Step 6 : Forward the gateway to your machine
`kubectl rollout status -n openfaas deploy/gateway`

`kubectl port-forward -n openfaas svc/gateway 8080:8080 &`

![image](https://user-images.githubusercontent.com/65301458/226157426-3dd3f3b4-31cc-4fb3-8664-443642d11e6d.png)


## Step 7: List of OpenFaas tepmplates in the store
command : `faas-cli template store list`
 
## Step 8: Create a new function with lang type Java11
command : `faas-cli new openfaasjavapoc-fn --lang java11`

## Step 9 : Login to your openfaas instance via faas-cli
command: `faas-cli login -u <user> --password-stdin`

## Step 10 : Build, push(to docker registry) and deploy your function
command : `faas-cli up -f ./openfaasjavapoc-fn.yml`

![image](https://user-images.githubusercontent.com/65301458/226157444-7342f8b4-caf3-49e3-bd4e-4f256423e3e1.png)

## Your OpenFaas UI should look like this after the above step
![image](https://user-images.githubusercontent.com/65301458/226159659-98273bee-fae5-485d-9c8a-4b4d6af29e00.png)

## Output Screen:

1. Input provided : "SocieteGenerale"

![image](https://user-images.githubusercontent.com/65301458/226160189-ee180c95-018f-4b46-883e-f5c6118a5983.png)

2. Invalid input

![image](https://user-images.githubusercontent.com/65301458/226160280-b0d44a5b-bc1b-4bf5-9ece-192453aeeb23.png)

