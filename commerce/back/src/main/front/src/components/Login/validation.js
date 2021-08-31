function validation(items) {
  let errors = {};
  if (items.username.thim() == "") {
    errors = {
      ...errors,
      username: "Username is empty",
    };
  }
  if (items.password.thim() == "") {
    errors = {
      ...errors,
      password: "Password is empty",
    };
  }
  return errors;
}

export { validation };
