function BlogDetails({ blogs }) {
  if (!blogs || blogs.length === 0) {
    return <p>No blogs found!!!</p>;
  }

  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {blogs.map((blog) => (
        <div>
          <h3>{blog.title}</h3>
          <strong>{blog.author}</strong>
          <p>{blog.desc}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
