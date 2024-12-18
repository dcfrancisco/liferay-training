# liferay-training
Liferay 7.3 practice (gradebook exercise)



## Folder Structure
```
liferay-training
    ├── configs
    │   ├── common
    │   ├── dev
    │   ├── docker
    │   ├── local
    │   ├── prod
    │   └── uat
    ├── modules
    │   ├── angular-routing-demo-portlet
    │   ├── angular-weather-app
    │   ├── gradebook
    │   │   ├── Gradebook-api 
    │   │   └── Gradebook-service 
    │   ├── gradebook-web
    │   │
    │   └── petclinic
    │       ├── petclinic-api 
    │       ├── petclinic-service 
    │       ├── owner-web 
    │       └── vet-web
    └── themes
        └── livingstone-fjord-theme
```

## Setup Environment

### Install JDK 11

__Linux__
```
sudo apt install openjdk-11-jdk
```
__Windows__
```
https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
```

### Install Nvm

__Windows__

* [Windows](https://learn.microsoft.com/en-us/windows/dev-environment/javascript/nodejs-on-windows)
* Linux
```agsl
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
```
* Mac
```
brew install nvm

```
__Install node 16__
```
nvm install 16  
```
__Use node 16__
```
nvm use 16
```
__Check node and npm version__
```
node -v

```
__Check npm version__
```
npm -v

```

__Install blade__

* [Windows](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-windows-installer.exe)
* [Linux](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-linux-x64-installer.run)
* [Mac](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-macosx-installer.dmg)

### Build the project

__Clone the repository__

```
git clone git@github.com:dcfrancisco/liferay-training.git
```

## Building the projects 
__Create bundle__

```
cd configs/local
blade gw initBundle
```
or
```
./gradlew initBundle
```

__Service Builder__

```
cd modules/gradebook/gradebook-service
blade gw buildService
cd ..
blade gw build
```
__Deploy gradebook-api and gradebook-service__
```
cd modules/grabook
blade gw deploy
```

__Build Gradebook-web__

```agsl
cd modules/gradebook-web
blade gw build
```
__Deploy Gradebook-web__

```
blade gw deploy
```

### Build Themes

```
cd themes/livingstone-fjord-theme
blade gw build
```




