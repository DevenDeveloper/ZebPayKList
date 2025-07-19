# 🚀 ZebPayKList

A **fluent DSL-based list builder** for Jetpack Compose, inspired by the `Modifier` chaining pattern. This project demonstrates a reusable, declarative, and animated list UI using a custom `KList` class.

---

## 📱 Demo

<img width="280" height="856" alt="Image" src="https://github.com/user-attachments/assets/06b23569-1e57-4c16-bde1-54390795c5be" />

---

## 🧩 Features

✅ Fluent DSL with `padding`, `header`, `subHeader`, `divider`, and `items`  
✅ Compose-native `LazyColumn` rendering  
✅ Reusable `KListItem` builder with click and animation support  
✅ Clean, scalable, and modular architecture  
✅ Optional animations using `AnimatedVisibility`  
✅ Inspired by `Modifier` chaining in Jetpack Compose

---

## 🏗️ Fluent DSL Example

```kotlin
KList()
    .padding(16.dp)
    .header("Top Gainers")
    .subHeader("Today's Information")
    .divider(1)
    .items(coinList) { coin ->
        KListItem.CoinCardItem(coin) {
            this.modifier(Modifier.padding(horizontal = 8.dp))
            this.animated(true)
            this.onClick {
                Toast.makeText(context, "${coin.name} clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
    .Render()


⸻

🧱 Folder Structure

📦 zebpayassignment
 ┣ 📂 ui
 ┃ ┣ 📂 klist
 ┃ ┃ ┣ 📂 compinent
 ┃ ┃ ┃ ┣ 📄 KList.kt                 // Fluent API core class
 ┃ ┃ ┃ ┣ 📄 KListItem.kt             // Sealed class with builder pattern
 ┃ ┃ ┃ ┣ 📄 KListRenderer.kt         // Renders the KList to UI
 ┃ ┃ ┃ ┣ 📄 CoinItemBuilder.kt       // Builder for CoinCard with DSL
 ┃ ┃ ┃ ┗ 📄 CoinCard.kt              // Composable item card UI
 ┃ ┃ ┗ 📄 KListDemo.kt               // Demo screen showing usage
 ┣ 📂 helper
 ┃ ┗ 📄 AnimatedKListItem.kt         // Optional animation wrapper
 ┣ 📂 models
 ┃ ┗ 📄 Coin.kt                      // Coin data model


⸻

🔧 Components Overview

✅ KList.kt
	•	Holds internal state of list items
	•	Provides modifier-style API (padding, header, items, etc.)
	•	Invokes Render() to display contents

✅ CoinItemBuilder.kt
	•	Builder DSL to construct CoinCard as KListItem.ComposableItem
	•	Supports chaining: .modifier(), .animated(), .onClick()

✅ KListRenderer.kt
	•	Renders content using LazyColumn
	•	Handles headers, dividers, composable items, and padding

✅ CoinCard.kt
	•	Custom composable card for each Coin
	•	Color-coded price change with icon indicator
	•	Click and animation support

⸻

✨ Bonus Features
	•	✅ [x] Item animations using AnimatedVisibility
	•	✅ [x] Custom onClick support via builder
	•	✅ [x] Dynamic padding support
	•	✅ [x] Declarative and readable API

⸻

🧪 Usage in a Composable

@Composable
fun HomeScreen() {
    val coins = listOf(
        Coin("Bitcoin", "$29,000", 1.25f),
        Coin("Ethereum", "$1,800", -0.85f)
    )

    KList()
        .padding(16.dp)
        .header("Trending Coins")
        .divider(1)
        .items(coins) {
            KListItem.CoinCardItem(it) {
                this.onClick { println("${it.name} clicked") }
            }
        }
        .Render()
}


⸻

🧪 Sample Output

Coin	Price	Change	Arrow
Bitcoin	$29,000	+1.25%	⬆️
Ethereum	$1,800	-0.85%	⬇️

Rows animate into view and respond to clicks.

⸻

🧠 Design Patterns Used
	•	DSL Builder Pattern – for CoinCardItem configuration
	•	Fluent API Design – inspired by Jetpack Compose’s Modifier
	•	Sealed Class Composition – for type-safe list item types
	•	Separation of Concerns – composables, logic, and builder are modular

⸻

🛠️ Build & Run
	1.	Clone the repo

git clone https://github.com/DevenDeveloper/ZebPayKList.git
cd ZebPayKList


	2.	Open in Android Studio Arctic Fox or later
	3.	Run KListDemo Activity

⸻

📸 Screenshots

(Add screenshots of your app UI here with animation previews, if possible)

⸻

⚠️ Known Issues
	•	Dividers and headers are currently linear (no section grouping)
	•	Not optimized for extremely large lists (pagination not implemented)

⸻

🤝 Contributions

Pull requests are welcome! Ideas for:
	•	Grouped headers
	•	Swipe-to-refresh
	•	Dynamic filters
	•	Sorting controls

⸻

📄 License

This project is for educational/demo purposes. No license applied.

⸻

🔗 Links
	•	Jetpack Compose Docs: https://developer.android.com/jetpack/compose
	•	Modifier Pattern Reference: https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier

⸻

🙌 Author

Made with ❤️ by @DevenDeveloper

⸻
