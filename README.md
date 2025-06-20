# ProLearn
ProLearn is a collaborative group study platform built using Spring Boot (Java). It helps students connect, form study groups, share resources, and collaborate in real time to enhance learning outcomes.



---


#  ProLearn – Group Study Platform

A web platform built using **Spring Boot + HTML/CSS/JS** that offers:

-  **Group Video Calling** using Firebase + WebRTC  
-  **File Upload to Google Drive** using Google Apps Script  

---

##  Features

### 1.  Group Video Calling
- Create and join calls
- Share link to join
- Mute/unmute mic
- Toggle camera
- Share screen
- Cleanly disconnect room

### 2.  Google Drive File Manager
- Create folders in Google Drive
- Upload files to selected folder
- View folder & file list
- Download files

---

## 🛠 Project Structure

```

src
└── main
└── resources
├── static
│   ├── config.js          # Contains Firebase and Script URL
│   └── other static files (CSS, images, etc.)
└── templates
├── index.html         # Video call UI
└── file-manager.html  # File upload UI

````

---

##  Setup Guide

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/prolearn.git
cd prolearn
````

---

### Step 2: Firebase Setup for Video Call

1. Go to [Firebase Console](https://console.firebase.google.com)
2. Create a project and add a web app
3. Get your Firebase config like this:

```js
const firebaseConfig = {
  apiKey: "AIza...",
  authDomain: "your-app.firebaseapp.com",
  projectId: "your-app-id",
  storageBucket: "your-app.appspot.com",
  messagingSenderId: "123456",
  appId: "1:123:web:abc"
};
```

4. Add the config in `src/main/resources/static/config.js`

```js
const CONFIG = {
  firebaseConfig: {
    apiKey: "AIza...",
    authDomain: "your-app.firebaseapp.com",
    projectId: "your-app-id",
    storageBucket: "your-app.appspot.com",
    messagingSenderId: "123456",
    appId: "1:123:web:abc"
  },
  scriptURL: "https://script.google.com/macros/s/AKfycb.../exec"
};
```

---

### Step 3: Google Apps Script Setup for File Upload

1. Open [Google Apps Script](https://script.google.com/)

2. Create a new project with functions for:

   * `createFolder`
   * `listFolders`
   * `uploadFile`
   * `listFiles`

3. Deploy as **Web App**

4. Copy the deployment URL

5. Add it to `scriptURL` in `config.js`

---

### Step 4: Git Ignore Secret File

Create `.gitignore` and add:

```
src/main/resources/static/config.js
```

⚠️ Don't upload your Firebase keys or script URLs to GitHub.

---

### Step 5: Firestore Setup

In Firebase Console → Firestore Database → Start in test mode
Use test rules like:

```js
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}
```

---

## ▶ Run the App

Use Spring Boot's built-in command:

```bash
./mvnw spring-boot:run
```

Then open:

* `http://localhost:8080/` → Group Video Call
* `http://localhost:8080/file-manager.html` → File Upload

---

##  How to Use

### Group Video Call

1. Click "Create Call"
2. Share the link shown
3. Others can join using "Join Call"
4. Use buttons for mic, camera, screen share
5. End call to clean up

### File Upload

1. Enter folder name → click "Create Folder"
2. Upload files into selected folder
3. View uploaded files with download link

---

##  Example config.js (Don't Share)

```js
const CONFIG = {
  firebaseConfig: {
    apiKey: "AIza...",
    authDomain: "your-app.firebaseapp.com",
    projectId: "your-app-id",
    storageBucket: "your-app.appspot.com",
    messagingSenderId: "123456",
    appId: "1:123:web:abc"
  },
  scriptURL: "https://script.google.com/macros/s/AKfycb.../exec"
};
```

---

##  Credits

Made by **Onkar Atole**
Aiming to simplify group learning for students.

---

##  Notes

* Keep `config.js` private
* Make sure Google Script has **public** permissions
* Firebase/Drive should have proper limits if using in production


