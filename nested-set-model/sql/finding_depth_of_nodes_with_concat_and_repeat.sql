SELECT CONCAT( REPEAT(' ', COUNT(parent.name)::int - 1), node.name) AS name, node.lft, node.rgt, node.id
FROM category AS node,
     category AS parent
WHERE node.lft BETWEEN parent.lft AND parent.rgt
GROUP BY node.name, node.lft, node.rgt, node.id
ORDER BY node.lft;


-- Result
name                 |lft|rgt|id|
---------------------+---+---+--+
ELECTRONICS          |  1| 24| 1|
 TELEVISIONS         |  2|  9| 2|
  TUBE               |  3|  4| 3|
  LCD                |  5|  6| 4|
  PLASMA             |  7|  8| 5|
 PORTABLE ELECTRONICS| 10| 23| 6|
  MP3 PLAYERS        | 11| 14| 7|
   FLASH             | 12| 13| 8|
  PORTELE2           | 15| 16|16|
  CD PLAYERS         | 17| 18| 9|
  2 WAY RADIOS       | 19| 22|10|
   Test              | 20| 21|15|