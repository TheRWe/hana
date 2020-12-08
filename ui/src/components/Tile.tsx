import { faMapMarkedAlt } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from "react";
import { RatingSummary } from "../common/interface/shared";
import { LocText } from "../components/LocText";
import { Rating } from "./Rating";

export enum EJobAdType {
  off = "nabídka",
  inq = "poptávka",
}

type TileProps = {
  imagePath?: string
  eventRating?: RatingSummary | undefined
  place?: string
  date?: string
  email?: string
  pay?: number
  jobType?: string
  userName?: string
  userRating?: RatingSummary | undefined
  heading: string
  text: string
  price?: string
  jobAdType?: EJobAdType
};

export const Tile: React.FC<TileProps> = ({ imagePath, place, date, email, pay, jobType, userName, userRating, eventRating, heading, text, price, jobAdType }: TileProps) => <>
  <article className="col-4 card card-pink">
    <header>
      {
        imagePath ? <img src={imagePath} alt="ntg" /> : undefined
      }
      <h3 className="card-title">{heading}</h3>
      <Rating rating={eventRating} />
    </header>
    <p className="card-description">
      {text}
    </p>
    <div className="tile-footer">
      <div className="card-information">
        {
          pay ?
            <div className="card-info-row">
              <p>
                <LocText
                  en="Pay:"
                  cz="Plat:"
                />
              </p>
              <p>{`${pay.toLocaleString()} Kč`}</p>
            </div>
            :
            undefined
        }
        {
          jobType ?
            <div className="card-info-row">
              <p>
                <LocText
                  en="Job type:"
                  cz="Druh:"
                />
              </p>
              <p>{jobType}</p>
            </div>
            :
            undefined
        }
        {
          email ?
            <div className="card-info-row">
              <p>Email</p>
              <p>{email}</p>
            </div>
            :
            undefined
        }
        {
          userName ?
            <div className="card-info-row">
              <p>
                <LocText
                  en="Name:"
                  cz="Jméno:"
                />
              </p>
              <p>
                {userName}
              </p>
              {
                <Rating rating={userRating} />
              }
            </div>
            :
            undefined
        }
        {
          place ?
            <div className="card-info-row">
              <p>
                <LocText
                  en="Place:"
                  cz="Místo:"
                />
              </p>
              <p>{place}</p>
              <FontAwesomeIcon icon={faMapMarkedAlt} />
            </div>
            :
            undefined
        }
        {
          date ?
            <div className="card-info-row">
              <p>
                <LocText
                  en="Date:"
                  cz="Datum:"
                />
              </p>
              <p>
                <time>{date}</time>
              </p>
            </div>
            :
            undefined
        }
      </div>
      <div className="card-more-info">
        <p className="right">
          <LocText
            en="MORE INFO"
            cz="VÍCE INFORMACÍ"
          />
        </p>
        {
          price ?
            <p className="left">{price}</p>
            :
            undefined
        }
        {
          jobAdType ?
            <p className="left">{jobAdType}</p>
            :
            undefined
        }
      </div>
    </div>
  </article>
</>;
