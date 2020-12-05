import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";
import { faStar as faStarEmpty } from "@fortawesome/free-regular-svg-icons";
import { RatingSummary } from "../common/interface/shared";
import { range } from "../common/utils";
import { LocText } from "./LocText";

type TRatingProps = {
  rating: RatingSummary | undefined,
};

export const Rating: React.FC<TRatingProps> = (props) => {
  const { rating } = props;

  // todo: empty rating text (empty stars faded back with text no rating in front of them)
  if (!rating) return <div className="card-rating">
    <LocText
      cz="Nehodnoceno"
      en="No ratings"
    />
  </div>;

  const ratingWhole = Math.round(rating.score);

  return <>
    <div className="card-rating">
      {
        range(5).map(x =>
          ratingWhole >= x
            ? <FontAwesomeIcon icon={faStar} />
            : <FontAwesomeIcon icon={faStarEmpty} />
        )
      }
      {
        ` x${rating.votesCount}`
      }
    </div>
  </>;
};
