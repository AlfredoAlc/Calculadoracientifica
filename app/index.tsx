import { ScrollView, StyleSheet, Text, View } from "react-native";

import { ERR } from "@/constants/buttons/actions";
import { useThemeColor } from "@/hooks/useThemeColor";
import Buttons from "@/components/Buttons";

import { Button } from "@/types/buttons";
import { tintColorAccent } from "@/constants/Colors";
import useCalculator from "@/hooks/useCalculator";

export default function HomeScreen() {
  const backgroundColor = useThemeColor({}, "background");

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop: 60,
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
      fontSize: 60,
      transform: [{ scaleX: -1 }],
      textAlignVertical: "bottom",
      textTransform: "uppercase",
    },
    prevActionText: {
      color: tintColorAccent,
      position: "absolute",
      fontSize: 30,
      top: 18,
      left: 18,
      transform: [{ scaleX: -1 }],
    },
  });

  const {
    currentNumber,
    error,
    hasDecimalPoint,
    prevActionName,
    calculate,
    setHasDecimalPoint,
    setCurrentNumber,
  } = useCalculator();

  const handleOnPress = (button: Button) => {
    if (typeof button.value !== "undefined") {
      let value = `${currentNumber}${button.value}`;
      if (hasDecimalPoint) {
        value = `${currentNumber}.${button.value}`;
        setHasDecimalPoint(false);
      }
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
        <Text style={styles.prevActionText}>{prevActionName}</Text>
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
        onPress={handleOnPress}
        hasValue={currentNumber > 0 || hasDecimalPoint}
        error={error}
      />
    </View>
  );
}
