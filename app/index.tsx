import { ScrollView, StyleSheet, Text, View } from "react-native";

import Buttons from "@/components/Buttons";
import { EQUAL, ERR } from "@/constants/buttons/actions";
import { tintColorAccent } from "@/constants/Colors";
import useThemeColor from "@/hooks/useThemeColor";
import useCalculator from "@/hooks/useCalculator";
import useOrientation from "@/hooks/useOrientation";

import { Button } from "@/types/buttons";

export default function HomeScreen() {
  const backgroundColor = useThemeColor({}, "background");

  const { isPortrait } = useOrientation();

  const {
    currentNumber,
    error,
    hasDecimalPoint,
    prevAction,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  } = useCalculator();

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop: isPortrait ? 60 : 30,
      backgroundColor,
    },
    scrollViewContainer: {
      flex: 0.2,
      transform: [{ scaleX: -1 }],
      alignContent: "flex-end",
    },
    textContainer: {
      paddingHorizontal: 20,
    },
    currentText: {
      color: "white",
      fontSize: isPortrait ? 60 : 30,
      transform: [{ scaleX: -1 }],
      textAlignVertical: "bottom",
      textTransform: "uppercase",
    },
    prevActionText: {
      color: tintColorAccent,
      position: "absolute",
      fontSize: isPortrait ? 30 : 15,
      top: isPortrait ? 18 : 4,
      left: 18,
      transform: [{ scaleX: -1 }],
    },
  });

  const handleOnPress = (button: Button) => {
    if (typeof button.value !== "undefined") {
      if (prevAction.action === EQUAL) return setCurrentNumber(button.value);
      const value = `${currentNumber}${hasDecimalPoint ? "." : ""}${
        button.value
      }`;
      if (hasDecimalPoint) setHasDecimalPoint(false);
      return setCurrentNumber(parseFloat(value));
    }
    calculate(button);
  };

  const renderNumber = () => {
    if (error) return ERR;
    if (currentNumber === 0) return "";
    try {
      const formattedNumber = currentNumber.toLocaleString("en-US", {
        maximumSignificantDigits: 10,
      });
      return formattedNumber;
    } catch (err) {
      console.log("renderNumber error: ", err);
      setCurrentNumber(0);
      return "";
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.scrollViewContainer}>
        <Text style={styles.prevActionText}>{prevAction.name}</Text>
        <ScrollView
          contentContainerStyle={styles.textContainer}
          directionalLockEnabled
          horizontal
          showsHorizontalScrollIndicator={false}
          overScrollMode="always"
        >
          <Text style={styles.currentText}>
            {renderNumber()}
            {hasDecimalPoint ? "." : ""}
          </Text>
        </ScrollView>
      </View>
      <Buttons
        error={error}
        hasValue={currentNumber > 0 || hasDecimalPoint}
        isPortrait={isPortrait}
        onPress={handleOnPress}
      />
    </View>
  );
}
