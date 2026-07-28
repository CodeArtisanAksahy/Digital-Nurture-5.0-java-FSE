import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat", score: 90 },
    { name: "Rohit", score: 85 },
    { name: "Dhoni", score: 95 },
    { name: "Rahul", score: 65 },
    { name: "Pant", score: 50 },
    { name: "Bumrah", score: 75 },
    { name: "Shami", score: 45 },
    { name: "Ashwin", score: 70 },
    { name: "Jadeja", score: 88 },
    { name: "Gill", score: 30 },
    { name: "Surya", score: 99 }
  ];

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p) => (
          <li>{p.name} - {p.score}</li>
        ))}
      </ul>


      <h2>Players with score &lt; 70</h2>
        <ul>
        {players.filter((p) => p.score <= 70)
            .map((p) => (
            <li>{p.name} - {p.score}</li>
        ))}
        </ul>
    </div>
  );
};

export default ListofPlayers;
