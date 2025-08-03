import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ name }) {
  const theme = useContext(ThemeContext);

  const buttonStyle = {
    backgroundColor: theme === "light" ? "#eee" : "#333",
    color: theme === "light" ? "#000" : "#fff",
    padding: "10px 20px",
    margin: "10px",
    border: "none",
    borderRadius: "5px"
  };

  return (
    <div>
      <p>Employee: {name}</p>
      <button style={buttonStyle}>View Details</button>
    </div>
  );
}

export default EmployeeCard;
