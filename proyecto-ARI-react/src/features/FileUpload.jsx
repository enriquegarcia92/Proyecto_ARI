import React, { useState, useEffect } from 'react';
import "../App.scss"

export const FileUpload = ({ files, setFiles, onContentChange }) => {
  const [file, setFile] = useState(null);
  const [content, setContent] = useState('');

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleUpload = async () => {
    if (file.type !== 'application/json' && file.type !== 'text/plain' && file.type !== 'text/xml') {
      alert('Invalid file type');
      return;
    }

    const reader = new FileReader();
    reader.onload = (event) => {
      const fileContent = event.target.result;
      setContent(fileContent);
      onContentChange(fileContent); // Pass the content value to the callback function
    };
    reader.readAsText(file);
  };

  const handleButtonClick = () => {
    handleUpload();
  };

  return (
    <div>
      <input type="file" name="file" id="file" onChange={handleFileChange} />
      <button className="btn btn-secondary"onClick={handleButtonClick}>Upload</button>
    </div>
  );
};

export default FileUpload;
