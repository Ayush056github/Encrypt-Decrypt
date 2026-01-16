document.addEventListener('DOMContentLoaded', function() {
    const keyInput = document.getElementById('key');
    const textInput = document.getElementById('text');
    const encryptBtn = document.getElementById('encrypt');
    const decryptBtn = document.getElementById('decrypt');
    const output = document.getElementById('output');
    const matrixDiv = document.getElementById('matrix');

    let keyMatrix = [];

    keyInput.addEventListener('input', generateKeyMatrix);
    encryptBtn.addEventListener('click', encrypt);
    decryptBtn.addEventListener('click', decrypt);

    function generateKeyMatrix() {
        const key = keyInput.value.toUpperCase().replace(/[^A-Z]/g, '').replace(/J/g, 'I');
        const alphabet = 'ABCDEFGHIKLMNOPQRSTUVWXYZ';
        let used = new Set();
        keyMatrix = [];

        // Add key letters
        for (let char of key) {
            if (!used.has(char)) {
                used.add(char);
                keyMatrix.push(char);
            }
        }

        // Add remaining letters
        for (let char of alphabet) {
            if (!used.has(char)) {
                used.add(char);
                keyMatrix.push(char);
            }
        }

        displayMatrix();
    }

    function displayMatrix() {
        matrixDiv.innerHTML = '';
        for (let i = 0; i < 5; i++) {
            for (let j = 0; j < 5; j++) {
                const cell = document.createElement('div');
                cell.className = 'matrix-cell';
                cell.textContent = keyMatrix[i * 5 + j];
                matrixDiv.appendChild(cell);
            }
        }
    }

    function prepareText(text, isEncrypt) {
        text = text.toUpperCase().replace(/[^A-Z]/g, '').replace(/J/g, 'I');
        let pairs = [];
        for (let i = 0; i < text.length; i += 2) {
            let a = text[i];
            let b = text[i + 1] || 'X';
            if (a === b) {
                b = 'X';
                i--; // repeat the second character
            }
            pairs.push([a, b]);
        }
        return pairs;
    }

    function findPosition(char) {
        const index = keyMatrix.indexOf(char);
        return [Math.floor(index / 5), index % 5];
    }

    function encrypt() {
        const text = textInput.value;
        const pairs = prepareText(text, true);
        let result = '';

        for (let [a, b] of pairs) {
            const [row1, col1] = findPosition(a);
            const [row2, col2] = findPosition(b);

            if (row1 === row2) {
                // Same row
                result += keyMatrix[row1 * 5 + (col1 + 1) % 5];
                result += keyMatrix[row2 * 5 + (col2 + 1) % 5];
            } else if (col1 === col2) {
                // Same column
                result += keyMatrix[((row1 + 1) % 5) * 5 + col1];
                result += keyMatrix[((row2 + 1) % 5) * 5 + col2];
            } else {
                // Rectangle
                result += keyMatrix[row1 * 5 + col2];
                result += keyMatrix[row2 * 5 + col1];
            }
        }

        output.value = result;
    }

    function decrypt() {
        const text = textInput.value;
        const pairs = prepareText(text, false);
        let result = '';

        for (let [a, b] of pairs) {
            const [row1, col1] = findPosition(a);
            const [row2, col2] = findPosition(b);

            if (row1 === row2) {
                // Same row
                result += keyMatrix[row1 * 5 + (col1 + 4) % 5];
                result += keyMatrix[row2 * 5 + (col2 + 4) % 5];
            } else if (col1 === col2) {
                // Same column
                result += keyMatrix[((row1 + 4) % 5) * 5 + col1];
                result += keyMatrix[((row2 + 4) % 5) * 5 + col2];
            } else {
                // Rectangle
                result += keyMatrix[row1 * 5 + col2];
                result += keyMatrix[row2 * 5 + col1];
            }
        }

        // Remove trailing X if added during encryption
        result = result.replace(/X$/, '');
        output.value = result;
    }

    // Initialize with default key
    keyInput.value = 'MONARCHY';
    generateKeyMatrix();
});