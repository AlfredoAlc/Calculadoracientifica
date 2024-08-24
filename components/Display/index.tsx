import { ScrollView, StyleSheet, Text, View } from "react-native";
import { tintColorAccent } from "@/constants/Colors";
import { ERR } from "@/constants/buttons/actions";
import { DisplayComponent } from "@/types/display";

export default function Display({
  currentNumber,
  error,
  hasDecimalPoint,
  isPortrait,
  prevActionName,
  setCurrentNumber,
}: DisplayComponent) {
  const styles = StyleSheet.create({
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
  );
}
