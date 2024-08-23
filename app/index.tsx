import { useRef, useState } from "react";
import { ScrollView, StyleSheet, Text, View } from "react-native";

import {
  ADD,
  CLEAR,
  CLEAR_ALL,
  DIVIDE,
  EQUAL,
  INVERSE,
  MULTIPLY,
  PERCENTAGE,
  POINT,
  SQUARE_ROOT,
  SUBSTRACT,
} from "@/constants/buttons/actions";
import {
  handleAdd,
  handleEqual,
  handleSquareRoot,
  handleSubstract,
} from "@/utils/actions";
import { useThemeColor } from "@/hooks/useThemeColor";
import Buttons from "@/components/Buttons";

import { Button } from "@/types/buttons";

const defaultTotal = { value: 0, prevAction: "" };

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
    },
  });

  const [currentNumber, setCurrentNumber] = useState(0);
  const [hasDecimalPoint, setHasDecimalPoint] = useState(false);
  const total = useRef(defaultTotal);

  const handleOnPress = (button: Button) => {
    if (typeof button.value !== "undefined") {
      let value = `${currentNumber}${button.value}`;
      if (hasDecimalPoint) {
        value = `${currentNumber}.${button.value}`;
        setHasDecimalPoint(false);
      }
      return setCurrentNumber(parseFloat(value));
    }

    switch (button.action) {
      case ADD:
        total.current = {
          value: handleAdd(
            currentNumber,
            total.current.value,
            total.current.prevAction
          ),
          prevAction: button.action,
        };
        setCurrentNumber(0);
        break;

      case CLEAR:
        setCurrentNumber(0);
        break;

      case CLEAR_ALL:
        total.current = defaultTotal;
        setCurrentNumber(0);
        break;

      case DIVIDE:
      case MULTIPLY:
        total.current = {
          value: currentNumber,
          prevAction: button.action,
        };
        setCurrentNumber(0);
        break;

      case EQUAL:
        setCurrentNumber(
          handleEqual(
            currentNumber,
            total.current.value,
            total.current.prevAction
          )
        );
        total.current = defaultTotal;
        break;

      case INVERSE:
        setCurrentNumber((prev) => -prev);
        break;

      case PERCENTAGE:
        setCurrentNumber((prev) => prev / 100);
        break;

      case POINT:
        if (!currentNumber.toString().includes(".")) setHasDecimalPoint(true);
        break;

      case SQUARE_ROOT:
        total.current = defaultTotal;
        setCurrentNumber(handleSquareRoot(currentNumber));
        break;

      case SUBSTRACT:
        total.current = {
          value: handleSubstract(currentNumber, total.current.value),
          prevAction: button.action,
        };
        setCurrentNumber(0);
        break;

      default:
        return;
    }
  };

  const renderNumber = () => {
    try {
      return currentNumber.toLocaleString("en-US", {
        maximumSignificantDigits: 10,
      });
    } catch (err) {
      console.log(err);
      console.log(currentNumber);
      setCurrentNumber(0);
      return 0;
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.scrollViewContainer}>
        <ScrollView
          contentContainerStyle={styles.textContainer}
          directionalLockEnabled
          horizontal
          showsHorizontalScrollIndicator={false}
          overScrollMode="always"
        >
          <Text style={styles.currentText}>
            {renderNumber()}
            {hasDecimalPoint && "."}
          </Text>
        </ScrollView>
      </View>
      <Buttons
        onPress={handleOnPress}
        hasValue={currentNumber > 0 && !!total.current.prevAction}
      />
    </View>
  );
}
