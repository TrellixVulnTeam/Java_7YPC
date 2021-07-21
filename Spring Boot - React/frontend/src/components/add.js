import React from "react";
import axios from "axios";

class AddNew extends React.Component {
  state = {
    //item: {
    name: "",
    // }
  };

  handleChange = (event) => {
    this.setState({ name: event.target.value });
    console.log(this.state.name);
  };

  handleSubmit = (event) => {
    event.preventDefault();

    // const hero = {
    //   name: this.state.name,
    // };

    axios
      .post(`http://localhost:8081/api/heroes`, { name: this.state.name })
      .then((res) => {
        console.log(res);
        console.log(res.data);
      });
  };

  render() {
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label>Enter name: </label>
            <input
              className="form-control"
              placeholder="Enter Name"
              name="Name"
              onChange={this.handleChange}
            />
          </div>

          <button type="submit" className="btn btn-primary">
            Add
          </button>
        </form>
      </div>
    );
  }
}

export default AddNew;
