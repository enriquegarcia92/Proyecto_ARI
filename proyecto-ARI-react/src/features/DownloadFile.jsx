import React from 'react';

const DownloadFile = ({ outputContent, outputType }) => {
  const downloadFile = () => {
    const element = document.createElement('a');
    const file = new Blob([outputContent], { type: outputType });
    element.href = URL.createObjectURL(file);
    
    // Set the file name based on the output type
    let fileName = 'file';
    if (outputType === 'text') {
      fileName += '.txt';
    } else if (outputType === 'json') {
      fileName += '.json';
    } else if (outputType === 'xml') {
      fileName += '.xml';
    }
    
    element.download = fileName;
    document.body.appendChild(element);
    element.click();
    document.body.removeChild(element);
  };

  return (
    <button className="btn btn-success" onClick={downloadFile}>
      Download file
    </button>
  );
};

export default DownloadFile;