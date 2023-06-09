import React, { useState } from "react";
import axios from "../api/axios";

const TEXT_TO_JSON_URL = "/text_Json/convert/secret";
const TEXT_TO_XML_URL = "/text_Xml/convert/secret";
const JSON_TO_TEXT_URL = "/json_Text/convert/secret";
const JSON_TO_XML_URL = "";
const XML_TO_TEXT_URL = "/xml_text/convert/secret";
const XML_TO_JSON_URL = "";

const ConvertFile = ({ inputString, inputType, outputType }) => {
  const [convertedString, setConvertedString] = useState("");

  const convertTextFile = async (url, inputString, type) => {
    try {
      const response = await axios.post(url, inputString, {
        headers: { "content-type": "application/" + type },
        withCredentials: false,
      });

      setConvertedString(response);
    } catch (err) {
      console.log(err);
    }
  };

  const textToJsonConversion = (inputString) => {
    console.log("text to json");
    convertTextFile(TEXT_TO_JSON_URL, inputString, "text");
  };

  const textToXmlConversion = (inputString) => {
    console.log("text to xml");
  };

  const jsonToTextConversion = (inputString) => {
    console.log("jsontotext");
  };

  const jsonToXmlConversion = (inputString) => {
    console.log("json to xml");
  };

  const xmlToTextConversion = (inputString) => {
    console.log("xml to text");
  };

  const xmlToJsonConversion = (inputString) => {
    console.log("xml to json");
  };

  const handleConvert = () => {
    switch (true) {
      case inputType == outputType:
        setConvertedString(inputString);
        break;

      case inputType == "1" && outputType == "2":
        textToJsonConversion(inputString);
        break;

      case inputType == "1" && outputType == "3":
        textToXmlConversion(inputString);
        break;

      case inputType == "2" && outputType == "1":
        jsonToTextConversion(inputString);
        break;

      case inputType == "2" && outputType == "3":
        jsonToXmlConversion(inputString);
        break;

      case inputType == "3" && outputType == "1":
        xmlToTextConversion(inputString);
        break;

      case inputType == "3" && outputType == "2":
        xmlToJsonConversion(inputString);
        break;

      default:
        break;
    }
  };

  return (
    <button className="btn btn-primary" onClick={handleConvert}>
      Convert
    </button>
  );
};

export default ConvertFile;
