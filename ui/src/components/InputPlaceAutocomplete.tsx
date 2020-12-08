import React, { useEffect, useRef } from "react";
import { TLocalizedText, useLocalized } from "./LocText";

export type Place = {
  lat: number,
  lng: number,
  name: string,
};

type TInputPlaceAutocompleteProps = {
  value: Place | undefined,
  onValueChange: (val: Place | undefined) => void,
  label: TLocalizedText,
};

export const InputPlaceAutocomplete: React.FC<TInputPlaceAutocompleteProps> = ({ value, onValueChange, label }) => {
  const parentRef = useRef<HTMLInputElement>(undefined as any);
  const name = label.en.replace(" ", "-").toLowerCase();

  useEffect(() => {
    (async () => {
      const input = parentRef.current;

      const autocomplete = new (window as any).google.maps.places.Autocomplete(input as any);

      autocomplete.setFields(["address_components", "geometry", "name"]);
      autocomplete.addListener("place_changed", () => {
        const placeAc = autocomplete.getPlace();

        const geo = placeAc.geometry?.location;
        const lat = geo?.lat() || 0;
        const lng = geo?.lng() || 0;
        const name = placeAc.name;
        if (lat)
          onValueChange({ name, lat, lng });
      });
    })();
  }, []);

  useEffect(() => {
    parentRef.current.value = value?.name || "";
  }, [value]);


  return <>
    <label htmlFor={name}>
      {useLocalized(label)}
    </label>
    <input id={name} name={name} ref={parentRef}></input>
  </>;
};
