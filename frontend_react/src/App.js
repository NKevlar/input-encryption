import React, { useState } from 'react';
import axios from 'axios';
import './App.css'

function EncryptForm() {
  const [value, setValue] = useState('');
  const [encryptedMsg, setEncryptedMsg] = useState(null);

  const handleChange = (event) => {
    setValue(event.target.value);
  }

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post(
        'http://localhost:8080/encrypt',
        { value: value }, // Use the 'value' state variable directly
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      );
      setEncryptedMsg(response.data.message);
    } catch (error) {
      // Handle errors
    }
  }

  return (
    <div class="encrypt-form">
      <form onSubmit={handleSubmit}>
        <label>Enter the value to encrypt:</label><br />
        <input type="text" value={value} onChange={handleChange} /><br />
        <input class="button" type="submit" value="Submit" />
      </form>
      <div class="message">Cyphered Message: {encryptedMsg}</div>
    </div>
  );
}

function App() {
  return (
    <EncryptForm />
  );
}

export default App;
