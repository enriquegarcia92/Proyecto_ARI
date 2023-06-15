import React, { useState, useEffect } from 'react';

const StringReplacement = ({ inputString, replacementChar, onStringChange, inputType}) => {
  const [newString, setNewString] = useState('');
  const [newLimiter, setNewLimiter] = useState('');

  const defineNewLimiter = (inputType) => {
     if(inputType == 'text'){ // TEXT
      setNewLimiter(';')
     }else if(inputType == '2'){ // JSON
      setNewLimiter('json')
     }else if(inputType == 'xml'){ // XML
      setNewLimiter('')
     }
  }

  useEffect(() => {
    replaceCharacter();
  }, [inputString, replacementChar, newString]);

  const replaceCharacter = () => {

    defineNewLimiter(inputType);

    if (inputString && replacementChar) {
      const updatedString = inputString.replace(new RegExp(replacementChar, 'g'), newLimiter);
      setNewString(updatedString);
      onStringChange(updatedString);
    } else {
      setNewString(inputString);
      onStringChange(inputString);
    }
  };

  return (
    <div>
      <p>{newString}</p>
    </div>
  );
};

export default StringReplacement;