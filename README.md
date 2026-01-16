# Encrypt-Decrypt: Play-Fair Cipher Application

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.java.com/)
[![HTML5](https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white)](https://html.spec.whatwg.org/)
[![CSS3](https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white)](https://www.w3.org/Style/CSS/)
[![JavaScript](https://img.shields.io/badge/JavaScript-ES6+-F7DF1E?logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

A comprehensive and user-friendly implementation of the Play-Fair Cipher algorithm for encryption and decryption. This project provides both web and desktop versions, making cryptography accessible and educational.

## �‍💻 About the Developer

**Ayush Mathur**  
*B.Tech 3rd Year - Information Technology*

This project showcases practical implementation of classical cryptography algorithms, demonstrating proficiency in multiple programming paradigms and technologies.

## �📋 Table of Contents
- [About the Developer](#-about-the-developer)- [Features](#-features)
- [Deployment](#-deployment)
- [Screenshots](#-screenshots)
- [Technologies Used](#-technologies-used)
- [Installation & Usage](#-installation--usage)
- [Algorithm Explanation](#-algorithm-explanation)
- [Project Structure](#-project-structure)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features

- **🔐 Dual Implementation**: Both web-based and desktop Java applications
- **🎨 Modern UI**: Professional, responsive web interface with gradient designs
- **📊 Visual Matrix Display**: Real-time visualization of the 5x5 cipher key matrix
- **⚡ Real-time Processing**: Instant encryption/decryption with live updates
- **📱 Responsive Design**: Works seamlessly on desktop and mobile devices
- **🛠️ Educational**: Includes algorithm explanations and visual aids
- **💻 Cross-Platform**: Java version runs on Windows, macOS, and Linux

## � Deployment

### Web Version on Vercel

The web application can be deployed on Vercel.

#### Deploy to Vercel Manually:
1. Connect your GitHub account to Vercel
2. Import your repository from GitHub
3. Deploy automatically - Vercel will detect the static site and deploy it
4. Custom domain (optional) - Add your own domain if desired

#### Local Development:
```bash
# Clone the repository
git clone https://github.com/Ayush056github/Encrypt-Decrypt.git
cd Encrypt-Decrypt

# Start local server
python -m http.server 8000

# Open in browser
# http://localhost:8000
```

### Desktop Version
The Java desktop application can be downloaded and run locally:
```bash
# Compile
javac PlayFairCipherGUI.java

# Run
java PlayFairCipherGUI
```

## 🛠️ Technologies Used

### Web Version
- **Frontend Framework**: Vanilla JavaScript (ES6+)
- **Styling**: CSS3 with modern features (Flexbox, Grid, Gradients)
- **Fonts**: Google Fonts (Roboto)
- **Browser Support**: Modern browsers (Chrome, Firefox, Safari, Edge)

### Desktop Version
- **Language**: Java 8+
- **GUI Framework**: Swing (javax.swing)
- **Build Tool**: javac (Java Compiler)
- **Platform**: Cross-platform (Windows, macOS, Linux)

### Development Tools
- **Version Control**: Git
- **Code Editor**: VS Code (recommended)
- **Web Server**: Python HTTP Server (for local testing)

## 🚀 Installation & Usage

### Web Version
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Ayush056github/Encrypt-Decrypt.git
   cd Encrypt-Decrypt
   ```

2. **Run locally:**
   ```bash
   python -m http.server 8000
   ```

3. **Open in browser:**
   Navigate to `http://localhost:8000` and open `index.html`

4. **Usage:**
   - Enter a key (e.g., "MONARCHY")
   - Type text to encrypt or decrypt
   - Click "Encrypt" or "Decrypt"
   - View the result and key matrix

### Desktop Version
1. **Prerequisites:** Java 8+ installed

2. **Compile:**
   ```bash
   javac PlayFairCipherGUI.java
   ```

3. **Run:**
   ```bash
   java PlayFairCipherGUI
   ```

4. **Usage:** Same as web version through the GUI interface

## 🔍 Algorithm Explanation

The Play-Fair Cipher is a digraph substitution cipher that uses a 5x5 matrix generated from a keyword.

### Key Matrix Generation
- Remove duplicates and 'J' (treated as 'I')
- Fill remaining spots with unused letters
- Creates a 5x5 grid for encryption/decryption

### Encryption Rules
- **Same Row**: Shift both letters one position to the right
- **Same Column**: Shift both letters one position down
- **Rectangle**: Swap letters with their counterparts in the rectangle

### Example
- **Key**: "MONARCHY"
- **Plaintext**: "HELLO"
- **Ciphertext**: "DMGSP" (processed in pairs: HE→DM, LL→GS, O→P)

## 📁 Project Structure

```
Encrypt-Decrypt/
├── index.html              # Main web page
├── styles.css              # Web application styling
├── script.js               # Web application logic
├── PlayFairCipherGUI.java  # Desktop Java application
├── README.md               # Project documentation
├── screenshots/            # Application screenshots (to be added)
└── *.class                 # Compiled Java bytecode files
```

## 🤝 Contributing

Contributions are welcome! Please feel free to:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Development Guidelines
- Follow existing code style
- Add comments for complex logic
- Test both web and desktop versions
- Update README for new features

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Made with ❤️ for cryptography enthusiasts**

*Star this repo if you find it helpful!* ⭐