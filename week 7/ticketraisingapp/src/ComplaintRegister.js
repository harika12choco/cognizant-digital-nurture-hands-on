// ComplaintRegister.js
import React, { useState } from 'react';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!name.trim() || !complaint.trim()) {
      alert("Please fill in both fields before submitting.");
      return;
    }

    const referenceNumber = Math.floor(100000 + Math.random() * 900000);
    alert(`Complaint submitted successfully!\nReference Number: ${referenceNumber}`);

    // Clear the form
    setName('');
    setComplaint('');
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>Complaint Register Form</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Enter Employee Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          style={{
            padding: '10px',
            margin: '10px',
            width: '300px',
            borderRadius: '5px',
            border: '1px solid #ccc'
          }}
        />
        <br />
        <textarea
          placeholder="Enter Complaint"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          rows={4}
          style={{
            padding: '10px',
            margin: '10px',
            width: '300px',
            borderRadius: '5px',
            border: '1px solid #ccc'
          }}
        />
        <br />
        <button
          type="submit"
          style={{
            padding: '10px 20px',
            backgroundColor: '#007bff',
            color: '#fff',
            border: 'none',
            borderRadius: '5px',
            cursor: 'pointer'
          }}
        >
          Submit Complaint
        </button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
