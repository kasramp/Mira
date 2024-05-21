const codeBox = document.querySelector('.code-box');
const tooltip = document.querySelector('.tooltip');

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
  const fileList = document.getElementById('file-list');
  fileList.innerHTML = '';
  const contentSeparator = document.querySelector('.content-separator');
  contentSeparator.classList.remove('hidden');
  for (const file of files) {
    const formData = new FormData();
    const listItem = document.createElement('li');
    formData.append('file', file);
    fetch('/', {
      method: 'POST',
      body: formData
    })
    .then(response => {
      response.json().then(payload => {
        if (response.ok) {
          const downloadLink = document.createElement('a');
          downloadLink.textContent = payload.url;
          downloadLink.href = payload.url;
          listItem.appendChild(downloadLink);
        } else {
          listItem.textContent = `file.name [failed]`;
        }
      })
    }).catch(error => {
      listItem.textContent = `file.name [failed]`;
    });
    fileList.appendChild(listItem);
  }
});