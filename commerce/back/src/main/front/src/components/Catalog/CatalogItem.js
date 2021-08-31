import React, { Fragment } from "react";
import CatalogDataService from "../../services/catalog-service";

export default class CatalogItem extends React.Component {
  constructor(props) {
    super(props);

    this.getCatalog = this.getCatalog.bind(this);
    

    this.state = {
      carrentCatalog: {
        id: null,
        name: "",
      },
      message: "",
    };
  }

  componentDidMount() {
    this.getCatalog(this.props.match.params.id);
  }

  getCatalog(id) {
    CatalogDataService.get(id)
      .then((response) => {
        this.setState({
          carrentCatalog: response.data,
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    const { carrentCatalog } = this.state;

    return (
      <div>        
          <div className="edit-form">
            <h4>Tutorial</h4>
            <div className="form-group">
              <label htmlFor="title">Title</label>
              <input
                type="text"
                className="form-control"
                id="title"
                value={carrentCatalog.name}
              />
            </div>
          </div>        
      </div>
    );
  }
}

export default connect(null, null)(CatalogItem);
