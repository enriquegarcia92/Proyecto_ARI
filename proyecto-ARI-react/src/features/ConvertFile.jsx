import React, { useState } from "react";
import axios from "../api/axios";

const ConvertFile = ({
  inputString,
  inputType,
  outputType,
  secret,
  onContentConversion,
}) => {
  const TEXT_TO_JSON_URL = "/text_Json/convert/" + secret;
  const TEXT_TO_XML_URL = "/text_Xml/convert/" + secret;
  const JSON_TO_TEXT_URL = "/json_Text/convert/" + secret;
  const XML_TO_TEXT_URL = "/xml_text/convert/" + secret;
  const TEXT_TO_JSON_CHAIN_CONCATENATOR = "response.data[0]";
  const NORMAL_CONCATENATOR = "response.data";
  const [convertedString, setConvertedString] = useState("");

  const convertTextFile = async (url, inputString, type, chainConcatenator) => {
    try {
      const response = await axios.post(url, inputString, {
        headers: { "content-type": "application/" + type },
        withCredentials: false,
      });

      const output = JSON.stringify(eval(chainConcatenator));

      onContentConversion(output);

    } catch (err) {
      onContentConversion("We were not able to convert your file, please check the instructions and try again")
    }
  };

  const textToJsonConversion = (inputString) => {
    convertTextFile(
      TEXT_TO_JSON_URL,
      inputString,
      "text",
      TEXT_TO_JSON_CHAIN_CONCATENATOR
    );
  };

  const textToXmlConversion = (inputString) => {
    convertTextFile(TEXT_TO_XML_URL, inputString, "text", NORMAL_CONCATENATOR);
  };

  const jsonToTextConversion = (inputString) => {
    convertTextFile(JSON_TO_TEXT_URL, inputString, "json", NORMAL_CONCATENATOR);
  };

  const xmlToTextConversion = (inputString) => {
    convertTextFile(XML_TO_TEXT_URL, inputString, "xml", NORMAL_CONCATENATOR);
  };

  const handleConvert = () => {
    // Handles conversion pairs
    switch (true) {
      case inputType == outputType: //same file type conversion attempt uses input as output
        onContentConversion(inputString);
        break;

      case inputType == "text" && outputType == "json": //TXT TO JSON
        textToJsonConversion(inputString);
        break;

      case inputType == "text" && outputType == "xml": //TXT TO XML
        textToXmlConversion(inputString);
        break;

      case inputType == "json" && outputType == "text": //JSON TO TXT
        jsonToTextConversion(inputString);
        break;

      case inputType == "xml" && outputType == "text": //XML TO TXT
        xmlToTextConversion(inputString);
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
