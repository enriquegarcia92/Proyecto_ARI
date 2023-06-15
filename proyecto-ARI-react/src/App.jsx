import { useEffect, useState } from "react";
import "./App.scss";
import { FileUpload } from "./features/FileUpload";
import StringReplacement from "./features/StringReplacement";
import ConvertFile from "./features/ConvertFile";
import DownloadFile from "./features/DownloadFile";

function App() {
  const [inputContent, setInputContent] = useState("");
  const [outputContent, setOutputContent] = useState("")
  const [replacementChar, setReplacementChar] = useState("");
  const [newString, setNewString] = useState("");
  const [inputType, setInputType] = useState("");
  const [outputType, setOutputType] = useState("");
  const [secret, setSecret] = useState("")

  // callback function sent as prop to FileUpload.jsx that retrieves uploaded file's content
  const handleContentChange = (content) => {
    setInputContent(content);
  };

  // callback function to retrieve string where limiter character has been replaced by back-end defined character
  const handleStringChange = (updatedString) => {
    setNewString(updatedString);
  };
  const handleLimiterChange = (event) => {

    setReplacementChar(event.target.value);
  };

  //callback function used to retrieve converted string from ConvertFile.jsx 
  const handleOutput = (convertedString) => {
    setOutputContent(convertedString)
  }

  return (
    <div className="Container">
      <div className="header">
        <h1 className="">TXT/JSON/XML Converter</h1>
      </div>
      <div className="converter_section">
        <p className="alert alert-secondary mt-4">Hello! you can use this website to convert your text/json/xml files, to use the converter: <br />
        1. Select a file from your computer and upload it. <br />
        2. Select your input and output file types. <br />
        3. Choose a secret to encrypt your cc number. <br />
        4. Input a limiter for your object's properties and download. <br />
        <b>limiter example:</b> name: User, age: 32 (limiter = ",")</p>
        <div className="converter">
          <div className="card">
            <div className="card-header">
              <h3 className="card-title me-3">Input</h3>
              <input
                type="text"
                className="form-control me-3"
                id="secretInput"
                placeholder="secret"
                value={secret}
                onChange={(e) => {setSecret(e.target.value)}}
              />
              <select
                type="text"
                className="form-select form-select-sm me-3"
                id="limiterInput"
                placeholder="limiter"
                onChange={(e) => {
                  setReplacementChar(e.target.value);
                }}
              >
                <option value=",">,</option>
                <option value=";">;</option>
                <option value="/">/</option>
                <option value="!">!</option>
                <option value="$">$</option>
                <option value="&">&</option>
              </select>
              <select
                className="form-select form-select-sm"
                aria-label=".form-select-sm example"
                onChange={(e) => {
                  setInputType(e.target.value);
                }}
              >
                <option value="no choice">Input Type</option>
                <option value="text">Text</option>
                <option value="json">JSON</option>
                <option value="xml">XML</option>
              </select>
            </div>
            <div className="card-body">
              <StringReplacement
                inputString={inputContent}
                replacementChar={replacementChar}
                onStringChange={handleStringChange}
                inputType={inputType}
              />
            </div>
            <div className="card-footer">
              <FileUpload onContentChange={handleContentChange} />
              <ConvertFile inputString={newString} inputType={inputType} outputType={outputType} secret={secret} onContentConversion={handleOutput}/>
            </div>
          </div>
          <div className="card">
            <div className="card-header">
              <h3 className="card-title">Output</h3>
              <select
                className="form-select form-select-sm"
                aria-label=".form-select-sm example"
                onChange={(e) => {
                  setOutputType(e.target.value);
                }}
              >
                <option value="no choice">Output Type</option>
                <option value="text">Text</option>
                <option value="json">JSON</option>
                <option value="xml">XML</option>
              </select>
            </div>
            <div className="card-body">
              {outputContent}
            </div>
            <div className="card-footer justify-content-center">
              <DownloadFile outputContent={outputContent} outputType={outputType}/>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
