# Play-Fair Cipher Encrypt/Decrypt Application

A comprehensive implementation of the Play-Fair Cipher for encryption and decryption, featuring both web and desktop versions.

## Features

- **Web Version**: Interactive HTML/CSS/JavaScript application with a modern, professional UI
- **Desktop Version**: Java Swing GUI application for offline use
- **Real-time Key Matrix Display**: Visual representation of the 5x5 cipher matrix
- **Encryption & Decryption**: Full support for both operations using the Play-Fair algorithm

## How to Use

### Web Version
1. Open `index.html` in any modern web browser
2. Enter your encryption key (e.g., "MONARCHY")
3. Input the text you want to encrypt or decrypt
4. Click "Encrypt" or "Decrypt" to see the result
5. View the generated key matrix on the right

### Desktop Version
1. Ensure Java is installed on your system
2. Compile: `javac PlayFairCipherGUI.java`
3. Run: `java PlayFairCipherGUI`
4. Use the GUI interface similarly to the web version

## Algorithm Details

The Play-Fair Cipher uses a 5x5 matrix generated from a keyword. It processes text in pairs of letters:

- **Same Row**: Letters shift right
- **Same Column**: Letters shift down
- **Rectangle**: Letters swap positions

Note: 'J' is treated as 'I', and text is processed in uppercase.

## Technologies Used

- **Web Version**: HTML5, CSS3, JavaScript (ES6+)
- **Desktop Version**: Java (Swing GUI)

## Files

- `index.html` - Main web page
- `styles.css` - Styling for web version
- `script.js` - JavaScript logic for web version
- `PlayFairCipherGUI.java` - Java source code for desktop version
- `*.class` - Compiled Java bytecode files

## Contributing

Feel free to fork this repository and submit pull requests for improvements or additional features.

## License

This project is open source and available under the MIT License.