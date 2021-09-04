import React, { Fragment } from "react";
import CatalogDataService from "../../services/catalog-service";
import { connect } from "react-redux";

import { getCatalogList } from "../../redux/actions/catalogs";

class CatalogList extends React.Component {
  constructor(props) {
    super(props);
    this.onChangeSearchTitle = this.onChangeSearchTitle.bind(this);
    this.refreshList = this.refreshList.bind(this);

    this.state = {
      catalogs: [],
      currentCatalog: null,
      currentIndex: -1,
      searchTitle: "",
    };
  }
  componentDidMount() {
    this.props.getCatalogList();
  }

  onChangeSearchTitle(e) {
    const searchTitle = e.target.value;

    this.setState({
      searchTitle: searchTitle,
    });
  }

  refreshList() {
    this.retrieveCatalogs();
    this.setState({
      currentCatalog: null,
      currentIndex: -1,
    });
  }

  render() {
    const { currentIndex } = this.state;
    const { catalogs } = this.props;

    return (
      <div className="list row container">
        <div className="col-md-6">
          <h4>Catalogs List</h4>

          <ul className="list-group">
            {catalogs &&
              catalogs.map((catalog, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                >
                  {catalog.name}
                </li>
              ))}
          </ul>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    catalogs: state.catalogReducer,
  };
};

export default connect(mapStateToProps, { getCatalogList })(CatalogList);
