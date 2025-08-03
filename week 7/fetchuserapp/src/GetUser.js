// GetUser.js
import React, { Component } from 'react';

class GetUser extends Component {
  constructor() {
    super();
    this.state = {
      user: null
    };
  }

  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then(res => res.json())
      .then(data => {
        this.setState({ user: data.results[0] });
      })
      .catch(error => {
        console.error("Error fetching user:", error);
      });
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h3 style={{ textAlign: 'center' }}>Loading user data...</h3>;
    }

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h1>User Details</h1>
        <h2>{user.name.title} {user.name.first}</h2>
        <img src={user.picture.large} alt="User" style={{ borderRadius: '50%', border: '2px solid #ccc' }} />
      </div>
    );
  }
}

export default GetUser;
