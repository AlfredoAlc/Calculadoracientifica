import { useState } from "react";
import { StyleSheet, View } from "react-native";
import { BannerAd, BannerAdSize } from "react-native-google-mobile-ads";

import Buttons from "@/components/Buttons";
import Display, { MAX_LENGTH } from "@/components/Display";
import { DEG, EQUAL, RAD } from "@/constants/buttons/actions";
import useThemeColor from "@/hooks/useThemeColor";
import useCalculator from "@/hooks/useCalculator";
import useOrientation from "@/hooks/useOrientation";

import { Button } from "@/types/buttons";
import { GradeType } from "@/types/utils/actions";

export default function HomeScreen() {
  const backgroundColor = useThemeColor({}, "background");

  const { isPortrait } = useOrientation();

  const [grade, setGrade] = useState<GradeType>(DEG);

  const {
    currentNumber,
    error,
    hasDecimalPoint,
    prevAction,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  } = useCalculator(grade);

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
    } else if (button.action === DEG || button.action === RAD) {
      setGrade(button.action);
    } else {
      calculate(button);
    }
  };

  return (
    <View style={styles.container}>
      <BannerAd
        unitId="ca-app-pub-4769341895289435/7697356506"
        size={BannerAdSize.ANCHORED_ADAPTIVE_BANNER}
      />
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
        grade={grade}
        hasValue={currentNumber > 0 || hasDecimalPoint}
        isPortrait={isPortrait}
        onPress={handleOnPress}
      />
    </View>
  );
}
