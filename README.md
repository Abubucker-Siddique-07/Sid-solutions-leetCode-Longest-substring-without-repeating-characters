# Sid-solutions-leetCode
My own solution for all the leet code problems focused on efficiency by reducing the time complexity of the problems to its best. 

## Complexity
Time complexity: O(n) --> 4ms

Space complexity: O(n) --> 44.24 mb

## Intuition
The Intuittion is to follow a simple start and end pointers similar to sliding window mechanism.

## Approach 
There is one simple loop that constantly traverses through each char at the string. There is a start pointer initialized to 0 and len, max initialized to 0 for storing the length of the substring and its maximum respectively.

```java
int len=0, start=0, max=0;
for (int i=0; i<s.length(); i++){
```

Use the Hash Map containsKey() as it take constant time to spot the repeating chars in the string. The Map is created to store the character as key and the respective index as the corresponding value.

```java
HashMap<Character, Integer> map = new HashMap<>();
map.put(s.charAt(i), i)
```

Update the start pointer in case, when you encounter duplicate characters in the string. set the start value to the index of the next character from the first occurance of the duplicate char, got through map.get()

```java
map.get(s.charAt(i));
start = map.get(s.charAt(i))+1;
```

Keep adding the keys to the map with distinct characters and also update the index value of the duplicate characters.

```java
map.put(s.charAt(i), i);
```

Calculate the len by subtracting the start from the current i in the loop which acts as your end pointer. Add 1 at the end to get the characters including the char at current index i.

```java
len = (i - start)+1;
```

Using Math.max() finc the max length and store it in the max variable.

```java
max = Math.max(len,max);
```

I've also tried to find the max of start pointers, because in some cases the the duplicates tend to go backward when getting from map, setting up the start lower than the previous. In this sliding widow approach, we are forcing the start pointer to proceed forward unidirectional and do not intend to step back and thus, keeping the max (previous_start, current _start) in the start pointer.

```java
start = Math.max(start ,map.get(s.charAt(i))+1);
```
