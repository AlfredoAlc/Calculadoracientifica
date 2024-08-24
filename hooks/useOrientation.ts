import { useEffect, useState } from "react";
import {
  addOrientationChangeListener,
  OrientationChangeEvent,
  removeOrientationChangeListener,
  Orientation,
} from "expo-screen-orientation";

const { PORTRAIT_UP } = Orientation;

export default function useOrientation() {
  const [orientation, setOrientation] = useState<Orientation>(PORTRAIT_UP);

  const isPortrait = orientation === PORTRAIT_UP;

  useEffect(() => {
    let subscription;

    const handleOrientationChange = ({
      orientationInfo,
    }: OrientationChangeEvent) => {
      setOrientation(orientationInfo.orientation);
    };

    if (!subscription) {
      subscription = addOrientationChangeListener(handleOrientationChange);
    }

    return () => removeOrientationChangeListener(subscription);
  });

  return { orientation, isPortrait };
}
