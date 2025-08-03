import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  return (
    <div>
      <EmployeeCard name="Alice" />
      <EmployeeCard name="Bob" />
      <EmployeeCard name="Charlie" />
    </div>
  );
}

export default EmployeesList;
