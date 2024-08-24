import { StyleSheet, View } from "react-native";

import Buttons from "@/components/Buttons";
import Display, { MAX_LENGTH } from "@/components/Display";
import { DEG, EQUAL, RAD } from "@/constants/buttons/actions";
import useThemeColor from "@/hooks/useThemeColor";
import useCalculator from "@/hooks/useCalculator";
import useOrientation from "@/hooks/useOrientation";

import { Button } from "@/types/buttons";
import { useState } from "react";

export default function HomeScreen() {
  const backgroundColor = useThemeColor({}, "background");

  const { isPortrait } = useOrientation();

  const [isDegree, setIsDegree] = useState(true);

  const {
    currentNumber,
    error,
    hasDecimalPoint,
    prevAction,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  } = useCalculator(isDegree);

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop: isPortrait ? 60 : 30,
      backgroundColor,
    },
  });

  const handleOnPress = (button: Button) => {
    if (typeof button.value !== "undefined") {
      if (currentNumber.toString().length >= MAX_LENGTH) return;
      if (prevAction.action === EQUAL) return setCurrentNumber(button.value);
      const value = `${currentNumber}${hasDecimalPoint ? "." : ""}${
        button.value
      }`;
      if (hasDecimalPoint) setHasDecimalPoint(false);
      return setCurrentNumber(parseFloat(value));
    } else if ([DEG, RAD].includes(button.action || "")) {
      setIsDegree(button.action === DEG);
    } else {
      calculate(button);
    }
  };

  return (
    <View style={styles.container}>
      <Display
        currentNumber={currentNumber}
        error={error}
        hasDecimalPoint={hasDecimalPoint}
        isPortrait={isPortrait}
        prevActionName={prevAction.name}
        setCurrentNumber={setCurrentNumber}
      />
      <Buttons
        error={error}
        hasValue={currentNumber > 0 || hasDecimalPoint}
        isDegree={isDegree}
        isPortrait={isPortrait}
        onPress={handleOnPress}
      />
    </View>
  );
}
