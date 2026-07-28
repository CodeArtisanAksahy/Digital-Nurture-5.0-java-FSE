function BookDetails({ books }) {
  return (
    <div>
      <h1>Book Details</h1>
      <ul>
        {books.length > 0 ? (
          books.map(book => (
            <li>
              <h3>{book.bname}</h3>
              <h4>{book.price}</h4>
            </li>
          ))
        ) : (
          <p>No books available</p>
        )}
      </ul>
    </div>
  );
}

export default BookDetails;