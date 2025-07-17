# Clarity Training – Liferay 7.4.3.132 📘

> ⚙️ Currently using: **Liferay CE 7.4.3.132-ga132**

This branch contains my hands-on progress from Liferay’s new **Clarity training** program, based on a fictional company named *Clarity*.

Modules and examples here are based on the official course, customized with my own additions and notes.

> ☕️ If this helps you learn faster, [buy me a coffee](https://www.buymeacoffee.com/dcfrancisco) 🙌


## 🚀 Quick Start

### 🧰 Requirements

- JDK 11
- Node 16 via NVM
- Blade CLI

### 🔧 Setup Environment

<details>
<summary>JDK 11</summary>

**Linux:**
```bash
sudo apt install openjdk-11-jdk
````

**Windows / macOS:**
Download from [Oracle JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

</details>

<details>
<summary>Node.js via NVM</summary>

**Install NVM:**

* **Linux:**

```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
```

* **macOS:**

```bash
brew install nvm
```

* **Windows:**
  [Official guide](https://learn.microsoft.com/en-us/windows/dev-environment/javascript/nodejs-on-windows)

**Install Node 16:**

```bash
nvm install 16
nvm use 16
```

</details>

<details>
<summary>Blade CLI</summary>

Download Blade CLI installer:

* [Windows](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-windows-installer.exe)
* [Linux](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-linux-x64-installer.run)
* [macOS](https://releases.liferay.com/tools/ide/3.9.8/LiferayWorkspace-202212271250-macosx-installer.dmg)

</details>

---

## 🛠️ Build & Deploy

### Clone this repository

```bash
git clone git@github.com:dcfrancisco/liferay-training.git
cd liferay-training
```

### Create the Bundle

```bash
cd configs/local
blade gw initBundle
# or
./gradlew initBundle
```

### Service Builder: Gradebook

```bash
cd modules/gradebook/gradebook-service
blade gw buildService
cd ..
blade gw build
```

### Deploy Gradebook

```bash
cd modules/gradebook
blade gw deploy
```

### Gradebook Web

```bash
cd modules/gradebook-web
blade gw build
blade gw deploy
```

### Theme

```bash
cd themes/livingstone-fjord-theme
blade gw build
```

---

## ☕ Support

If you’ve found this repo useful or it saved you time, consider [buying me a coffee](https://www.buymeacoffee.com/dcfrancisco) — it’s a small way to say thanks and help keep the motivation going!

---

## 📬 Contact

Reach out via GitHub or connect on [LinkedIn](https://www.linkedin.com/in/dannyfrancisco/) (if applicable).

