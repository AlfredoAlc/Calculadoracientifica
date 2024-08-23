import { Pressable, StyleSheet, Text, View } from "react-native";
import { Button, ButtonComponent, ButtonLine } from "@/types/buttons";
import { lines } from "./lines";
import { tintColorAccent } from "@/constants/Colors";
import { CLEAR, CLEAR_ALL } from "@/constants/buttons/actions";

export default function Buttons({
  onPress,
  hasValue,
}: Readonly<ButtonComponent>) {
  const renderItem = (item: Button) => {
    const isClearAllButton = item.action === CLEAR && !hasValue;
    return (
      <Pressable
        key={item.id}
        style={styles.buttonContainer}
        onPress={() =>
          onPress(isClearAllButton ? { ...item, action: CLEAR_ALL } : item)
        }
      >
        <Text
          style={
            !!item.action ? styles.buttonTextWhite : styles.buttonTextAccent
          }
        >
          {isClearAllButton ? "ac" : item.name}
        </Text>
      </Pressable>
    );
  };

  return (
    <View style={styles.container}>
      {lines.map((line: ButtonLine, index) => (
        <View key={`${line[0].id}-${index}`} style={styles.lineContainer}>
          {line.map(renderItem)}
        </View>
      ))}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 0.8,
  },
  lineContainer: {
    flex: 1,
    flexDirection: "row",
  },
  buttonContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  buttonTextAccent: {
    fontSize: 28,
    color: tintColorAccent,
    textTransform: "uppercase",
  },
  buttonTextWhite: {
    fontSize: 28,
    color: "white",
    textTransform: "uppercase",
  },
});
