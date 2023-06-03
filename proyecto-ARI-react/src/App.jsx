import "./App.scss";
import { FileUpload } from "./features/FileUpload";

function App() {
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
              />
              <select
                className="form-select form-select-sm"
                aria-label=".form-select-sm example"
              >
                <option value="1" selected>
                  Text
                </option>
                <option value="2">JSON</option>
                <option value="3">XML</option>
              </select>
            </div>
            <div className="card-body">

            </div>
            <div className="card-footer">
              <FileUpload />
              <button className="btn btn-primary me-3">Convert</button>
            </div>
          </div>
          <div className="card">
            <div className="card-header">
              <h3 className="card-title">Output</h3>
              <select
                className="form-select form-select-sm"
                aria-label=".form-select-sm example"
              >
                <option value="1" selected>
                  Text
                </option>
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
