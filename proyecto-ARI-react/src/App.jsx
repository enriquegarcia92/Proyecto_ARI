import { useState } from "react";
import "./App.scss";
import { FileUpload } from "./features/FileUpload";
import axios from "./api/axios";
import StringReplacement from "./features/StringReplacement";
import ConvertFile from "./features/ConvertFile";

function App() {
  const [inputContent, setInputContent] = useState("");
  const [replacementChar, setReplacementChar] = useState("");
  const [newString, setNewString] = useState("");
  const [inputType, setInputType] = useState("");
  const [outputType, setOutputType] = useState("");

  // callback function sent as prop to FileUpload.jsx that retrieves uploaded file's content
  const handleContentChange = (content) => {
    setInputContent(content);
  };

  // callback function to retrieve string where limiter character has been replaced by ";"
  const handleStringChange = (updatedString) => {
    setNewString(updatedString);
    console.log(newString);
  };

  //function that runs everytime limiter input changes to generate a string where the limiter is replaced by ";"
  const handleLimiterChange = (event) => {
    setReplacementChar(event.target.value);
  };

  return (
    <div className="Container">
      <div className="header">
        <h1 className="">JSON/XML Converter</h1>
      </div>
      <div className="converter_section">
        <div className="converter">
          <div className="card">
            <div className="card-header">
              <h3 className="card-title me-3">Input</h3>
              <input
                type="text"
                className="form-control me-3"
                id="secretInput"
                placeholder="secret"
              />
              <input
                type="text"
                className="form-control me-3"
                id="limiterInput"
                placeholder="limiter"
                value={replacementChar}
                onChange={handleLimiterChange}
              />
              <select
                className="form-select form-select-sm"
                aria-label=".form-select-sm example"
                onChange={(e) => {
                  setInputType(e.target.value);
                }}
              >
                <option value="0">Input Type</option>
                <option value="1">Text</option>
                <option value="2">JSON</option>
                <option value="3">XML</option>
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
              <ConvertFile inputString={newString} inputType={inputType} outputType={outputType}/>
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
                <option value="0">Output Type</option>
                <option value="1">Text</option>
                <option value="2">JSON</option>
                <option value="3">XML</option>
              </select>
            </div>
            <div className="card-body"></div>
            <div className="card-footer justify-content-center">
              <button className="btn btn-success">Download File</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
