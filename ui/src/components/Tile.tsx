import React, { useContext } from "react";
import { LocText } from "../components/LocText";

export enum EJobAdType {
  off = "nabídka",
  inq = "poptávka",
}

type TileProps = {
  imagePath?: string
  eventRating?: string
  place?: string
  date?: string
  email?: string
  pay?: string
  jobType?: string
  userName?: string
  userRating?: string
  heading: string
  text: string
  price?: string
  jobAdType?: EJobAdType
};


export const Tile: React.FC<TileProps> = ({ imagePath, place, date, email, pay, jobType, userName, userRating, eventRating, heading, text, price, jobAdType }: TileProps) => <>
  <article className="tile">
    <header>
      {
        imagePath ? <img src={imagePath} alt="no-image-yet" /> : undefined
      }
      <h3>{heading}</h3>
      {
        eventRating ?
          <div className="rating event-rating">
            {eventRating}
          </div>
          :
          undefined
      }
    </header>
    <p>
      {text}
    </p>
    <footer className="tile-footer">
      <div className="tile-footer__info">
        {
          pay ?
            <div className="tile-footer-info-row">
              <p>
                <LocText
                  en="Pay"
                  cz="Plat"
                />
              </p>
              <p>{pay}</p>
            </div>
            :
            undefined
        }
        {
          jobType ?
            <div className="tile-footer-info-row">
              <p>
                <LocText
                  en="Job type"
                  cz="Druh"
                />
              </p>
              <p>{jobType}</p>
            </div>
            :
            undefined
        }
        {
          email ?
            <div className="tile-footer-info-row">
              <p>Email</p>
              <p>{email}</p>
            </div>
            :
            undefined
        }
        {
          userName ?
            <div className="tile-footer-info-row">
              <p>
                <LocText
                  en="Name"
                  cz="Jméno"
                />
              </p>
              <p>
                {userName}
              </p>
              {
                userRating ?
                  <div className="rating user-rating">
                    {userRating}
                  </div>
                  :
                  undefined
              }
            </div>
            :
            undefined
        }
        {
          place ?
            <div className="tile-footer-row">
              <p>
                <LocText
                  en="Place"
                  cz="Místo"
                />
              </p>
              <p>{place}</p>
            </div>
            :
            undefined
        }
        {
          date ?
            <div className="tile-footer-row">
              <p>
                <LocText
                  en="Date"
                  cz="Datum"
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
      <div className="tile-footer__price">
        <p>
          <LocText
            en="more info"
            cz="více informací"
          />
        </p>
        {
          price ?
            <p>{price}</p>
            :
            undefined
        }
        {
          jobAdType ?
            <p>{jobAdType}</p>
            :
            undefined
        }
      </div>
    </footer>
  </article>
</>;
