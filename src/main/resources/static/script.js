const codeBox = document.querySelector('.code-box');
const tooltip = document.querySelector('.tooltip'); // Get the tooltip element

codeBox.addEventListener('click', copyToClipboard);

function copyToClipboard() {
  const text = codeBox.textContent;
  navigator.clipboard.writeText(text)
    .then(() => {
      tooltip.classList.add('copied');
      setTimeout(() => {
        tooltip.classList.remove('copied');
      }, 500);
      console.log('Copied to clipboard!');
    })
    .catch(() => {
      console.error('Failed to copy to clipboard!');
    });
}

const uploadLink = document.getElementById('upload-link');
const fileInput = document.getElementById('file-input');

uploadLink.addEventListener('click', function(event) {
  event.preventDefault();
  fileInput.click();
});

fileInput.addEventListener('change', function(event) {
  const files = document.getElementById('file-input').files;
  for (const file of files) {
    const formData = new FormData();
    formData.append('file', file);
    fetch('/', {
      method: 'POST',
      body: formData
    })
    .then(response => {
      if (response.ok) {
        alert('File uploaded successfully!');
        // Handle successful upload response (optional)
      } else {
        alert('Upload failed. Please try again.');
      }
    })
    .catch(error => {
      alert('Error uploading file: ' + error);
    });
  }
});