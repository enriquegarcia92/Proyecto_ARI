import React, { useState, useEffect } from 'react';

const StringReplacement = ({ inputString, replacementChar, onStringChange}) => {
  const [newString, setNewString] = useState('');

  useEffect(() => {
    replaceCharacter();
  }, [inputString, replacementChar, newString]);

  const replaceCharacter = () => {
    if (inputString && replacementChar) {
      const updatedString = inputString.replace(new RegExp(replacementChar, 'g'), ',');
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