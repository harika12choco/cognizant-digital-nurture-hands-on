// Register.js
import React, { useState } from 'react';

function Register() {
  const [form, setForm] = useState({
    name: '',
    email: '',
    password: ''
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validate = () => {
    let err = {};

    if (form.name.length < 5) {
      err.name = "Name must be at least 5 characters.";
    }

    if (!form.email.includes('@') || !form.email.includes('.')) {
      err.email = "Enter a valid email.";
    }

    if (form.password.length < 8) {
      err.password = "Password must be at least 8 characters.";
    }

    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      alert("Registration Successful!");
      setForm({ name: '', email: '', password: '' });
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: 'auto', marginTop: '50px' }}>
      <h2 style={{ textAlign: 'center' }}>Register</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={form.name}
          onChange={handleChange}
          style={{ width: '100%', padding: '10px', marginBottom: '5px' }}
        />
        {errors.name && <p style={{ color: 'red' }}>{errors.name}</p>}

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
          style={{ width: '100%', padding: '10px', marginBottom: '5px' }}
        />
        {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          style={{ width: '100%', padding: '10px', marginBottom: '5px' }}
        />
        {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}

        <button
          type="submit"
          style={{
            width: '100%',
            padding: '10px',
            backgroundColor: '#28a745',
            color: 'white',
            border: 'none',
            borderRadius: '5px'
          }}
        >
          Register
        </button>
      </form>
    </div>
  );
}

export default Register;
