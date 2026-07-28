export function EvenPlayers({ allPlayers }) {
  const [, second, , fourth, , sixth] = allPlayers;
  return (
    <ul>
      <li>Second: {second}</li>
      <li>Fourth: {fourth}</li>
      <li>Sixth: {sixth}</li>
    </ul>
  );
}