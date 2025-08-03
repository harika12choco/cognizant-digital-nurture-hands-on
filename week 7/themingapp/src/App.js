import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

function App() {
  const [theme, setTheme] = useState("light");

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1>Employee Theme App</h1>
        <button onClick={toggleTheme} style={{
          padding: '10px 20px',
          marginBottom: '30px',
          borderRadius: '5px',
          backgroundColor: theme === "light" ? "#ddd" : "#444",
          color: theme === "light" ? "#000" : "#fff",
          border: 'none'
        }}>
          Toggle Theme
        </button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
